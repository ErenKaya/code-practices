package kim.eren.oca_8_certificate.core.watch.apache;

import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.vfs.FileChangeEvent;
import org.apache.commons.vfs.FileListener;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.VFS;
import org.apache.commons.vfs.impl.DefaultFileMonitor;

public class ApacheWatcher {

	public static void main(String[] args) throws FileSystemException, InterruptedException {
		FileSystemManager manager = VFS.getManager();
		FileObject fileObject = manager.resolveFile("C:\\Users\\erenk\\Documents\\selam.txt");
		DefaultFileMonitor monitor = new DefaultFileMonitor(new FileListener() {
			@Override
			public void fileDeleted(FileChangeEvent arg0) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void fileCreated(FileChangeEvent arg0) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void fileChanged(FileChangeEvent arg0) throws Exception {
				System.out.println("selam changed");

			}
		});
		monitor.addFile(fileObject);
		monitor.start();
		while (true) {
		}
	}

}
