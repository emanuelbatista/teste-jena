package edu.ifpb.pod.teste.jena;


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.sdb.SDBFactory;
import com.hp.hpl.jena.sdb.Store;
import com.hp.hpl.jena.sdb.StoreDesc;
import com.hp.hpl.jena.sdb.sql.SDBConnection;
import com.hp.hpl.jena.sdb.store.DatabaseType;
import com.hp.hpl.jena.sdb.store.LayoutType;
import edu.ifpb.geosertao.OntoDataBaseFacade;


/**
 *
 * @author emanuel
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        OntoDataBaseFacade ontoDataBaseFacade=
                new OntoDataBaseFacade("jdbc:postgresql://localhost:5432/yago", "postgres", "123456", LayoutType.LayoutTripleNodesHash, DatabaseType.PostgreSQL);
        ontoDataBaseFacade.createBase("file:///home/emanuel/MEGA/GeoSertão/Ontologia/rdf_loa2012.ttl");
//        ontoDataBaseFacade.emptyBase();
        
        
        
    }
}
