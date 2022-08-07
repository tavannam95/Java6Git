package edu.poly.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.poly.bean.Student;

public class StreamAPI {

	static List<Student> listStudents = Arrays.asList(
				new Student("Ta Van Nam",true, 8),
				new Student("Nguyen Quoc Khanh",true, 5),
				new Student("Do Thi Hien",false, 2)
			);

	public static void main(String[] args) {
		demo4();
	}

	private static void demo4() {

		double avg = listStudents.stream()
				.mapToDouble(sv -> sv.getMarks())
				.average().getAsDouble();
		System.out.println("AVG: " + avg);
		
		double sum = listStudents.stream()
				.mapToDouble(sv -> sv.getMarks())
				.sum();
		System.out.println("SUM: " + sum);
		
		double minMarks = listStudents.stream()
				.mapToDouble(sv -> sv.getMarks())
				.min().getAsDouble();
		System.out.println("MIN: " + minMarks);
		
		double maxMarks = listStudents.stream()
				.mapToDouble(sv -> sv.getMarks())
				.max().getAsDouble();
		System.out.println("MAX: " + maxMarks);
		
		boolean allPassed = listStudents.stream()
				.allMatch(sv -> sv.getMarks()>=5);
		System.out.println(allPassed?"Yes":"No");
		
		Student minStudent = listStudents.stream().
				reduce(listStudents.get(0), (min,sv) -> sv.getMarks() < min.getMarks() ? sv : min);
		System.out.println(minStudent.getName());
		
		List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
		int computedAges = ages.parallelStream().reduce(0, (a, b) -> a + b);
		System.out.println(computedAges);
	}

	private static void demo3() {
		List<Student> list = listStudents.stream()
				.filter(n -> n.getMarks() >= 1 && n.isGender() == true)
				.peek(n -> n.setName(n.getName().toUpperCase()))
				.collect(Collectors.toList());
		
		list.forEach(sv -> {
			System.out.println(">> Name: " + sv.getName());
			System.out.println(">> Marks: " + sv.getMarks());
			System.out.println();
		});
	}

	private static void demo2() {

		List<Integer> list = Arrays.asList(1, 9, 7, 4, 5, 2);
		List<Double> result = list.stream()
				.filter(n -> n % 2 == 0)
				.map(n -> Math.sqrt(n))
				.peek(d -> System.out.println(d)).collect(Collectors.toList());

	}

	private static void demo1() {
		Stream<Integer> stream1 = Stream.of(1, 9, 7, 4, 5, 2);
		stream1.forEach(n -> {
			System.out.println(n);
		});
	}
}
