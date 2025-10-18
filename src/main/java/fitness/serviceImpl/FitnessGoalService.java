package fitness.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitness.helper.EnumCollections.Goal;
import fitness.models.FitnessGoal;
import fitness.repository.FitnessGoalRepository;

@Service
public class FitnessGoalService {
@Autowired
private FitnessGoalRepository fitnessGoalRepository;

public List<FitnessGoal> getAllFitnessGoals(){
	return fitnessGoalRepository.findAll();
}
public List<FitnessGoal> getFitnessGoalsById(Goal goal){
	return fitnessGoalRepository.findByGoal(goal);
	
}
public FitnessGoal createFitnessGoal(FitnessGoal fitnessGoal) {
	return fitnessGoalRepository.save(fitnessGoal); 
}
public void deleteFitnessGoal(Long id) {
	fitnessGoalRepository.deleteById(id);
}
public FitnessGoal updateFitnessGoal(Long id, FitnessGoal fitnessGoal) {
	FitnessGoal existing = fitnessGoalRepository.findById(id).orElse(null);
	if(existing != null) {
		existing.setTitle(fitnessGoal.getTitle());
		existing.setDuration(fitnessGoal.getDuration());
		existing.setCost(fitnessGoal.getCost());
		existing.setLeve(fitnessGoal.getLeve());
		existing.setGoal(fitnessGoal.getGoal());
		existing.setImageUrl(fitnessGoal.getImageUrl());
		existing.setType(fitnessGoal.getType());
	}
	return null;
}
}
