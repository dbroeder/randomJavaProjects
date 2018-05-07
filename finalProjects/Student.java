package finalProjects;

public class Student {
	private String name;
	private double[]  tests;
	private double[] quizzes;
	private double[] homeworks;
	private double averageTest;
	private double averageQuiz;
	private double averageHomework;
	private double overallAverage;
	
	public Student(String name){
		
		this.setName(name);
	}
	
	public void createTests(int size){
		tests=new double[size];
	}
	
	public void createQuizzes(int size){
		quizzes=new double[size];
	}
	
	public void createHomeworks(int size){
		homeworks=new double[size];
	}
	
	public void addTest(int index,double test){
		tests[index]=test;
	}
	public void addQuiz(int index,double quiz){
		quizzes[index]=quiz;
	}
	public void addHomework(int index,double homework){
		homeworks[index]=homework;
	}
	public double getOverallAverage() {
		overallAverage=(averageTest+averageQuiz+averageHomework)/3;
		return overallAverage;
	}
	
	public double getAverageHomework() {
		averageHomework=average(homeworks);
		return averageHomework;
	}
	public void setAverageHomework(double averageHomework) {
		this.averageHomework = averageHomework;
	}
	public double getAverageQuiz() {
		averageQuiz=average(quizzes);
		return averageQuiz;
	}
	public void setAverageQuiz(double averageQuiz) {
		this.averageQuiz = averageQuiz;
	}
	public double getAverageTest() {
		averageTest=average(tests);
		return averageTest;
	}
	public void setAverageTest(double averageTest) {
		this.averageTest = averageTest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double average(double[] array){
		double sum=0;
		for(int d=0;d<array.length;d++){
			sum+=array[d];
		}
		return sum/array.length;
	}
	
}
