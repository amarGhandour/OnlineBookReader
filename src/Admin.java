public class Admin extends User {

	@Override
	public void viewProfile() {

		StringBuilder sb = new StringBuilder();
		sb.append("\nAdmin ").append(getName()).append(" profile:\n").append("\tname: ").append(getName()).append("\n\temail: ")
				.append(getEmail());
		sb.trimToSize();
		System.out.println(sb.toString());

	}

}
