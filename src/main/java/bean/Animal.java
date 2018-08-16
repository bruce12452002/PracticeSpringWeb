package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Animal {
	@Autowired
	private Bird b;

	public Bird getB() {
		return b;
	}

	public void setB(Bird b) {
		this.b = b;
	}

}
