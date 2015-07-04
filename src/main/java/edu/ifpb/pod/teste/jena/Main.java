package edu.ifpb.pod.teste.jena;

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
        ontoDataBaseFacade.readData("file:///home/emanuel/Documentos/tsv/ttl/geonames/yagoGeonamesClasses.ttl");
        ontoDataBaseFacade.readData("file:///home/emanuel/Documentos/tsv/ttl/geonames/yagoGeonamesClassIds.ttl");
        ontoDataBaseFacade.readData("file:///home/emanuel/Documentos/tsv/ttl/geonames/yagoGeonamesEntityIds.ttl");
        ontoDataBaseFacade.readData("file:///home/emanuel/Documentos/tsv/ttl/geonames/yagoGeonamesGlosses.ttl");
        ontoDataBaseFacade.readData("file:///home/emanuel/Documentos/tsv/ttl/geonames/yagoGeonamesOnlyData.ttl");
        ontoDataBaseFacade.readData("file:///home/emanuel/Documentos/tsv/ttl/geonames/yagoGeonamesTypes.ttl");
        ontoDataBaseFacade.readData("file:///home/emanuel/Documentos/tsv/ttl/geonames/yagoGeonamesTypesSources.ttl");
        ontoDataBaseFacade.close();
        
        

    }
}


