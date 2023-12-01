package org.vegetablesales.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.Customer;
import org.vegetablesales.Model.Feedback;
import org.vegetablesales.Model.VegetableDTO;
import org.vegetablesales.Repository.FeedbackRepository;
@Service
public class FeedbackServiceImpl implements IFeedbackService{
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private VegetableDTO vege;
	@Autowired
	private Customer customer;

	@Override
	public Feedback addfeedback(Feedback fdbk) {
		return feedbackRepository.save(fdbk);
	}

	@Override
	public List<Feedback> viewAllFeedbacks(Integer vegetableId) {
		List<Feedback> list1 = feedbackRepository.findAll();
		List<Feedback> list2 = new ArrayList<>();
		for(Feedback fdbk:list1) {
			vege = fdbk.getVegetable();
			if(vege.getVegId()==vegetableId)
				list2.add(fdbk);
		}
        if(list2.isEmpty())
            return null;
        return list2;

	}

	@Override
	public List<Feedback> viewFeedback(Integer custId) {
		List<Feedback> list1 = feedbackRepository.findAll();
		List<Feedback> list2 = new ArrayList<>();
		for(Feedback fdbk:list1) {
			customer = fdbk.getCustomer();
			if(customer.getCustomerId()==custId)
				list2.add(fdbk);
		}
        if(list2.isEmpty())
            return null;
        return list2;
	}

}
