package edu.poly.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student3 {
	@NotBlank(message = "Email không được để trống!")
	@Email(message = "Email không đúng định dạng!")
	String email;
	@NotBlank(message = "Họ tên không được để trống!")
	String fullname;
	@NotNull(message = "Điểm không được để trống!")
	@Max(value = 10, message = "Điểm không được cao hơn 10!")
	@PositiveOrZero(message = "Điểm không được âm!")
	Double marks;
	@NotNull(message = "Vui lòng chọn giới tính!")
	Boolean gender;
	@NotBlank(message = "Vui lòng chọn quốc tịch!")
	String country;
}
