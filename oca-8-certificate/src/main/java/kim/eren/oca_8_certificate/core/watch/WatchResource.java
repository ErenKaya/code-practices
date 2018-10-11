package kim.eren.oca_8_certificate.core.watch;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchResource {
	private final WatchService watcher;
	private final Path dir;

	/**
	 * Creates a WatchService and registers the given directory
	 */
	public WatchResource(Path dir) throws IOException {
		this.watcher = FileSystems.getDefault().newWatchService();
		dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY);
		this.dir = dir;
	}

	/**
	 * Process all events for the key queued to the watcher.
	 */
	public void processEvents(Path target) {
		for (;;) {

			// wait for key to be signaled
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException x) {
				return;
			}

			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind kind = event.kind();

				if (kind == OVERFLOW) {
					continue;
				}

				// The filename is the context of the event.
				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				Path filename = ev.context();
				if (filename.toString().contains("bundle")) {
					System.err.format("New file '%s' is not a plain text file.%n", filename);
					String strDir = Paths.get(dir.toUri()).toString();
					String strTarget = Paths.get(target.toUri()).toString();
					try {
						Files.copy(Paths.get(strDir, "bundle.js"), Paths.get(strTarget, "bundle.js"),
								StandardCopyOption.REPLACE_EXISTING);
					} catch (NoSuchFileException x) {
						System.err.format("%s: no such" + " file or directory%n", strDir);
					} catch (DirectoryNotEmptyException x) {
						System.err.format("%s not empty%n", strDir);
					} catch (IOException x) {
						// File permission problems are caught here.
						System.err.println(x);
					}
				}
				continue;

			}

			// Reset the key -- this step is critical if you want to receive
			// further watch events. If the key is no longer valid, the directory
			// is inaccessible so exit the loop.
			boolean valid = key.reset();
			if (!valid) {
				break;
			}
		}
	}

	static void usage() {
		System.err.println("usage: java WatchResource dir target");
		System.exit(-1);
	}

	public static void main(String[] args) throws IOException {
		// parse arguments
		if (args.length < 1)
			usage();

		// register directory and process its events
		Path dir = Paths.get(args[0]);
		Path target = Paths.get(args[1]);
		new WatchResource(dir).processEvents(target);
	}
}
