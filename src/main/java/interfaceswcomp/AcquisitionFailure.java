public class AcquisitionFailure extends Exception {

	private static final long serialVersionUID = 5841746343397324667L;

	public AcquisitionFailure(Exception e) {
		super("Binding Failure: "+e);

	}

}
