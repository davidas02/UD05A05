/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class CuentaDaoCsv implements CuentaDao{
private Path path;
public CuentaDaoCsv(String path) {
        this.path =Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
    @Override
    public int guardar(List<Cuenta> listado) throws DaoException {
       int n=0;
        try(BufferedWriter fichero=Files.newBufferedWriter(path)){
            for(Cuenta c: listado){
                fichero.write(getClass().getSimpleName()+","+c.toString());
                fichero.newLine();
                n++;
            }
        }catch(IOException ex){
            throw new DaoException(ex.toString());
        }
        return n;
    }

    @Override
    public List<Cuenta> listar() throws DaoException {
        List<Cuenta> listado;
        listado = new ArrayList<>();
        String linea;
        
      try(BufferedReader fichero=Files.newBufferedReader(path)){
           linea=fichero.readLine();
           while(linea!=null){
                 
           linea=fichero.readLine();
           }
        }catch(IOException ex){
            throw new DaoException(ex.toString());
        }
      return listado;
    }
    
}
