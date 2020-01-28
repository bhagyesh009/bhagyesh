package com.bitwise.Data;

import java.util.List;

public class Output {

	private int data;
	private List<Success> successList;
	private List<Failure> failureList;
	

	public Output() {
		super();
	}


	public Output(int data, List<Success> successList, List<Failure> failureList) {
		super();
		this.data = data;
		this.successList = successList;
		this.failureList = failureList;
	}
	

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public List<Success> getSuccessList() {
		return successList;
	}

	public void setSuccessList(List<Success> successList) {
		this.successList = successList;
	}

	public List<Failure> getFailureList() {
		return failureList;
	}

	public void setFailureList(List<Failure> failureList) {
		this.failureList = failureList;
	}


	@Override
	public String toString() {
		return "Output [data=" + data + ", successList=" + successList + ", failureList=" + failureList + "]";
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
