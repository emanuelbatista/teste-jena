package edu.ifpb.geosertao;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.sdb.SDBFactory;
import com.hp.hpl.jena.sdb.Store;
import com.hp.hpl.jena.sdb.StoreDesc;
import com.hp.hpl.jena.sdb.sql.SDBConnection;
import com.hp.hpl.jena.sdb.store.DatabaseType;
import com.hp.hpl.jena.sdb.store.LayoutType;

/**
 * Responsável por manipular as ações de definição do banco de dados
 * que representa o modelo de ontologia.
 * @author Emanuel Batista
 */
public class OntoDataBaseFacade {
     
    private Store store;
    
    public OntoDataBaseFacade(String url,String usuario,String senha,LayoutType layout,DatabaseType baseType) {
        StoreDesc storeDesc=new StoreDesc(layout, baseType);
        SDBConnection con=new SDBConnection(url, usuario, senha);
        this.store=SDBFactory.connectStore(con, storeDesc);
    }

    public OntoDataBaseFacade(SDBConnection con,LayoutType layout,DatabaseType baseType) {
        StoreDesc storeDesc=new StoreDesc(layout, baseType);
        this.store=SDBFactory.connectStore(con, storeDesc);
    }
    
    public OntoDataBaseFacade(SDBConnection con,StoreDesc storeDesc){
        this.store=SDBFactory.connectStore(con, storeDesc);
    }
   
    /**
     * Criar um banco de dados de uma onotologia, a partir da url de um arquivo de ontologia 
     * @param url caminho do arquivo da ontologia
     * @return {@link Model}
     */
    public Model createBase(String url){
        this.store.getTableFormatter().create();
        Model model=SDBFactory.connectDefaultModel(store);
        model.begin();
        model.read(url);
        model.commit();
        return model;
    }
    /**
     * Retorna o modelo que representa a ontologia
     * @return {@link Model} o modelo que representa a ontologia
     */
    public Model getModel(){
        return SDBFactory.connectDefaultModel(store);
    }
    
    /**
     * Esvazia o banco de dados da ontologia
     */
    public void emptyBase(){
        this.store.getTableFormatter().truncate();
    }
    
    /**
     * Fecha a conexão com banco de dados
     */
    public void close(){
        store.getConnection().close();
        store.close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
