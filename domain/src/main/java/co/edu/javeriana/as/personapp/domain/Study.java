package co.edu.javeriana.as.personapp.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Study {
	@NonNull
	private Person person;
	@NonNull
	private Profession profession;
	private LocalDate graduationDate;
	private String universityName;

	public Boolean isValidGraduationDateDay() {
		return this.graduationDate.getDayOfMonth() > 0 && this.graduationDate.getDayOfMonth() <= 31;
	}

	public Boolean isValidGraduationDateYear() {
		return this.graduationDate.getYear() > 1900 && this.graduationDate.getYear() <= 2025;
	}
}
