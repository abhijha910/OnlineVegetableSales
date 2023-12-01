package org.vegetablesales.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vegetablesales.Model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{
	
}
