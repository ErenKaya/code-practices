package io.erenkaya.akaldiroglu._08_example.processors.domain;

import java.time.LocalDateTime;

public interface ProBean {

	public void preProcessesDate(LocalDateTime date);

	public void afterProcessesDate(LocalDateTime date);

	public void setName(String name);

}
