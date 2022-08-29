package io.erenkaya.oacar._4_chapter.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaHome {
	@Value("#{systemProperties['user.home']}")
	private String path;

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return String.format("JavaHome:{%s}", this.getPath());
	}
}
