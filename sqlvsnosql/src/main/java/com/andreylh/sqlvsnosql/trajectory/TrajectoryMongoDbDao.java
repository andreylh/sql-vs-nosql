package com.andreylh.sqlvsnosql.trajectory;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.andreylh.sqlvsnosql.database.mongodb.MongoDbDriver;
import com.andreylh.sqlvsnosql.log.Log;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.InsertManyOptions;

class TrajectoryMongoDbDao implements TrajectoryDao {

	@Override
	public long insertManyAndGetTime(List<Trajectory> trajectories) throws Exception {
		long startTime = 0;
		long endTime = 0;
		long totalTime = 0;
		
		if (trajectories.size() == 0) {
			return 0;
		}
		
		try {
			
			MongoCollection<Document> collection = MongoDbDriver.getInstance().getConnection()
					.getCollection("default");
			
			//collection.deleteMany(new Document());			
			
			List<Document> documents = trajectoriesToDocuments(trajectories);

			Log.log("Executing insert for %d", trajectories.size());
			startTime = System.currentTimeMillis();			
			collection.insertMany(documents, new InsertManyOptions().ordered(false));
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalTime;
	}

	@Override
	public long findByCoordinateAndGetTime(double longitude, double latitude) {
		// TODO Auto-generated method stub
		return 0;
	}

	private List<Document> trajectoriesToDocuments(List<Trajectory> trajectories) {
		List<Document> documents = new ArrayList<>();

		trajectories.forEach(t -> documents.add(t.getDocument()));

		return documents;
	}

}
