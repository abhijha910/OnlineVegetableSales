package org.vegetablesales.Service;

import java.util.List;

import org.vegetablesales.Model.Feedback;

public interface IFeedbackService {
	public Feedback addfeedback(Feedback fdbk);
	public List<Feedback> viewAllFeedbacks(Integer vegetableId);
	public List<Feedback> viewFeedback(Integer custId);
}
