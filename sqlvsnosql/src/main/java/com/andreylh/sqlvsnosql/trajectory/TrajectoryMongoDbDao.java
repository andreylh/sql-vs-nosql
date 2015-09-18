package com.andreylh.sqlvsnosql.trajectory;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.andreylh.sqlvsnosql.database.mongodb.MongoDbDriver;
import com.andreylh.sqlvsnosql.log.Log;
import com.mongodb.client.MongoCollection;

class TrajectoryMongoDbDao implements TrajectoryDao {

	@Override
	public long insertMany(List<Trajectory> trajectories) throws Exception {
		MongoCollection<Document> collection = MongoDbDriver.getInstance().getConnection().getCollection("trajectory");	
		
		List<Document> documents = trajectoriesToDocuments(trajectories);
		
		Log.log("Start insert for %d documents", documents.size());
		long startTime = System.currentTimeMillis();
		collection.insertMany(documents);
		long endTime = System.currentTimeMillis();
		Log.log("Insert for %d documents executed successfully", documents.size());
		
		return endTime - startTime;		
	}

	@Override
	public Trajectory findByCoordinate(double longitude, double latitude) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<Document> trajectoriesToDocuments(List<Trajectory> trajectories) {
		List<Document> documents = new ArrayList<>();
		
		trajectories.forEach(t -> documents.add(t.getDocument()));
		
		return documents;
	}

}
