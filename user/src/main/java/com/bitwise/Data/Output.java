package com.bitwise.Data;

public class Output {

	private int data;
	private Success success;
	private Failure failure;

	public Output(int data, Success success, Failure failure) {
		super();
		this.data = data;
		this.success = success;
		this.failure = failure;
	}

	public Output(int data, Success success) {
		super();
		this.data = data;
		this.success = success;
	}

	public Output(int data, Failure failure) {
		super();
		this.data = data;
		this.failure = failure;
	}

	public Output() {
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Success getSuccess() {
		return success;
	}

	public void setSuccess(Success success) {
		this.success = success;
	}

	public Failure getFailure() {
		return failure;
	}

	public void setFailure(Failure failure) {
		this.failure = failure;
	}

	@Override
	public String toString() {
		return "Output [data=" + data + ", success=" + success + ", failure=" + failure + "]";
	}

	public class Success {
		private int successCode;
		private String successMessge;

		public Success(int successCode, String successMessge) {
			super();
			this.successCode = successCode;
			this.successMessge = successMessge;
		}

		public int getSuccessCode() {
			return successCode;
		}

		public void setSuccessCode(int successCode) {
			this.successCode = successCode;
		}

		public String getSuccessMessge() {
			return successMessge;
		}

		public void setSuccessMessge(String successMessge) {
			this.successMessge = successMessge;
		}

		@Override
		public String toString() {
			return "Success [successCode=" + successCode + ", successMessge=" + successMessge + "]";
		}

	}

	public class Failure {
		private int errorCode;
		private String errorMessage;

		public Failure(int errorCode, String errorMessage) {
			super();
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
		}

		public Failure() {

		}

		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		@Override
		public String toString() {
			return "Failure [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
		}

	}

}
