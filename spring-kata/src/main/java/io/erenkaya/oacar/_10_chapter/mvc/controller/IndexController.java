/**
 * 
 */
package io.erenkaya.oacar._10_chapter.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author erenk
 *
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public String index(final ModelMap model) {
		model.addAttribute("title", "Araç Kiralama Servisi");
		return "index";
	}

}
