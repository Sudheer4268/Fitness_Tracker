package fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fitness.helper.EnumCollections.Goal;
import fitness.models.FitnessGoal;
import fitness.serviceImpl.FitnessGoalService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/fitnessgoal")
public class FitnessGoalController {

	@Autowired
	private FitnessGoalService service;
	
	@GetMapping("/all")
	public List<FitnessGoal> getAllFitnessGoal(){
		return service.getAllFitnessGoals();
	}
	@GetMapping("/goal/{goal}")
	public List<FitnessGoal> getFitnessGoalsById(@PathVariable Goal goal){
		return service.getFitnessGoalsById(goal);
	}
	@PostMapping("/add")
	public FitnessGoal createFitnessGoal(@RequestBody FitnessGoal fitnessGoal) {
		return service.createFitnessGoal(fitnessGoal);
	}
	@PutMapping("/update/{id}")
	public FitnessGoal updateFitnessGoal(@PathVariable Long id, @RequestBody FitnessGoal fitnessGoal) {
		return service.updateFitnessGoal(id, fitnessGoal);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteFitnessGoal(@PathVariable Long id) {
		service.deleteFitnessGoal(id);
	}
}
