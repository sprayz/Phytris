/*
 *  @author Pablo Morillas Lozano
 */
package proyecto.blocktris.logica.fisica.piezas.rompibles;

import java.util.List;

import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.extension.physics.box2d.util.constants.PhysicsConstants;

import proyecto.blocktris.logica.fisica.piezas.IPieza;
import proyecto.blocktris.logica.fisica.piezas.IPieza.PIEZAS;
import proyecto.blocktris.logica.fisica.piezas.rompibles.PiezaBase.Bloque;
import proyecto.blocktris.logica.fisica.piezas.rompibles.PiezaBase.Bloque.ColorBloque;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;

// TODO: Auto-generated Javadoc
/**
 * The Class PiezaT.
 */
public class PiezaT extends PiezaBase {

	/**
	 * Crea una pieza  de tipo T
	 * 
	 * @param mundo
	 *            el mundo
	 * @param x
	 *            coordenada x
	 * @param y
	 *            coordenada y
	 * @param tamaño_bloque
	 *            el tamaño del bloque
	 * @param fixturedef
	 *            la propiedades de los bloques
	 * @param bodydef
	 *            las propiedades de la pieza
	 */
	public PiezaT(PhysicsWorld mundo, float x, float y, float tamaño_bloque,
			FixtureDef fixturedef,BodyDef bodydef) {
		super(mundo, x, y, tamaño_bloque, fixturedef, bodydef);
		tipo= PIEZAS.PIEZA_T;
		 float xf = x / PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT;
		 float yf = y / PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT;
	
		
		cuerpo= mundo.createBody(bodydef);
		bloques.add(new Bloque(mundo,cuerpo,-1,0,tamaño_bloque,ColorBloque.ARENA ,fixturedef));
		bloques.add(new Bloque(mundo,cuerpo,0,0,tamaño_bloque,ColorBloque.ARENA,fixturedef ));
		bloques.add(new Bloque(mundo,cuerpo,1,0,tamaño_bloque,ColorBloque.ARENA ,fixturedef ));
		bloques.add(new Bloque(mundo,cuerpo,0,1,tamaño_bloque,ColorBloque.ARENA,fixturedef ));
		cuerpo.setTransform(xf, yf, 0);
		 
		
		bloques.get(0).getAdyacentes().add(bloques.get(1));
	
		cuerpo.setUserData(this); 
		
		bloques.get(1).getAdyacentes().add(bloques.get(2));
		bloques.get(1).getAdyacentes().add(bloques.get(3));
		bloques.get(1).getAdyacentes().add(bloques.get(0));

		bloques.get(2).getAdyacentes().add(bloques.get(1));

		
		
		
		bloques.get(3).getAdyacentes().add(bloques.get(1));
		
		 for(Bloque b: bloques){
			 b.setPadre(this);
			 this.contenedor.attachChild(b.getGrafico());
		 }
		
		 this.mundo = mundo;
			this.conector = new PhysicsConnector(contenedor, cuerpo);
			
			 mundo.registerPhysicsConnector(conector);
		
		 
	}
	

	

	

}
