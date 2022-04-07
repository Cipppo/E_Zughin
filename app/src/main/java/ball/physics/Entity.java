package ball.physics;

/**
 * 
 * need to define which thing is an entity. By now we've 
 * defined that everything that occupies a 2 dimensional
 * space could be described by this interface.
 *
 */
public interface Entity {
	
	/**
	 * 
	 * @return the position occupied by this entity.
	 */
	SpherePos2D getPosition();
	
	/**
	 * We got to define how to return the space occupied
	 * by an entity. We could try to design everything as
	 * a square and return the area to be calculated from 
	 * the position occupied by it.
	 * @return the area of the space occupied
	 */
	int getSize();
	
	
}
