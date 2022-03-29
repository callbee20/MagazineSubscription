package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Subscriber;
import dmacc.repository.SubscriberRepository;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Mar 20, 2022
 */
@Controller
public class WebController {

	@Autowired
	SubscriberRepository repo;

@GetMapping({"/", "viewAll"})
public String viewAllSubscribers(Model model) {
	if(repo.findAll().isEmpty()) {
		return addNewSubscriber(model);
	}
	model.addAttribute("subscribers", repo.findAll());
	return "results";
	}

@GetMapping("/inputSubscriber")
public String addNewSubscriber(Model model) {
	Subscriber s = new Subscriber();
	model.addAttribute("newSubscriber", s);
	return "input";
}

@PostMapping("/inputSubscriber")
public String addNewSubscriber(@ModelAttribute Subscriber s, Model model) {
	repo.save(s);
	return viewAllSubscribers(model);
}

@GetMapping("/edit/{id}")
public String showUpdateSubscriber(@PathVariable("id") long id, Model model) {
	Subscriber s = repo.findById(id).orElse(null);
	model.addAttribute("newSubscriber", s);
	return "input";
}

@PostMapping("/update/{id}")
public String reviseSubscriber(Subscriber s, Model model) {
	repo.save(s);
	return viewAllSubscribers(model);
}


@GetMapping("/delete/{id}")
public String deleteUser(@PathVariable("id") long id, Model model) {
	Subscriber s = repo.findById(id).orElse(null);
	repo.delete(s);
	return viewAllSubscribers(model);
}

}