package br.edu.ifsp.ddm.ifbook.ws.servidor.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeradorDeHash {

	public String gerar(String senha) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(senha.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}
}
