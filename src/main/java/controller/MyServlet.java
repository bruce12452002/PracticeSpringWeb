package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import bean.Animal;
import bean.Bird;

@WebServlet("*.xxx")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory()
				.autowireBean(this);
	}

	@Autowired
	private Animal a;

	@Autowired
	private Bird b;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

		for (String s : app.getBeanDefinitionNames()) {
			System.out.println(s);
		}
		Animal a = app.getBean(Animal.class);
		System.out.println(a.getB());

		System.out.println(this.a);
		System.out.println(b);
	}

}
