package io.erenkaya.akaldiroglu._08_example.processors.domain;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanA implements ProBean {

	private String name;

	private LocalDateTime preInitDate;

	private LocalDateTime afterInitDate;

	@Override
	public void preProcessesDate(LocalDateTime date) {
		this.preInitDate = date;

	}

	@Override
	public void afterProcessesDate(LocalDateTime date) {
		this.afterInitDate = date;
	}

	@PostConstruct
	public void postConstruct() {
		System.err.println("PreInit for [A]");
	}

	@PreDestroy
	public void preDestroy() {
		System.err.println("PreDestroy for [A]");
	}

	@Autowired
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Bean[A]=[name=%s, preInitDate=%s, preAfterDate=%s]", this.name, this.preInitDate,
				this.afterInitDate);
	}

}
