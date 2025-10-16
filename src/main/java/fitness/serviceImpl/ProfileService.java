package fitness.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitness.models.Profile;
import fitness.repository.ProfileRepository;

@Service
public class ProfileService {
@Autowired
private ProfileRepository profileRepository;

public List<Profile> getAllProfiles(){
	return profileRepository.findAll();
}
public Profile getById(Long id) {
	return profileRepository.findById(id).orElse(null);
}
public Profile createProfile(Profile profile) {
	return profileRepository.save(profile);
}
public void deleteProfile(Long id) {
	profileRepository.deleteById(id);
}
public Profile updateProfile(Long id, Profile profile) {
    Profile existing = profileRepository.findById(id).orElse(null);
    if (existing != null) {
        existing.setName(profile.getName());
        existing.setAge(profile.getAge());
        existing.setGender(profile.getGender());
        existing.setHeight(profile.getHeight());
        existing.setWeight(profile.getWeight());
        existing.setGoal(profile.getGoal());
        return profileRepository.save(existing);
    }
    return null;
}

}
