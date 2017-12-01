/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faiip
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Accountdb extends Homepage{
    private ArrayList<String> nameLst = new ArrayList<String>();
    private ArrayList<String> passLst = new ArrayList<String>();

    static ClassLoader loader = Accountdb.class.getClassLoader();
    static Scanner sc = new Scanner(System.in);

    public Accountdb(String filename) {
	loadFile(filename);
    }

    public ArrayList<String> getNameList() {
	return nameLst;
    }

    public void setNameList(ArrayList<String> nameLst) {
	this.nameLst = nameLst;
    }

    public ArrayList<String> getPassList() {
	return passLst;
    }

    public void setPriceList(ArrayList<String> passList) {
	this.passLst = passList;
    }

    public String userName(String name) {
		for (int i = 0; i < name.length(); i++) {
			char Charac = name.charAt(i);
			if (name.charAt(0) == ';') {
				break;
			} else if (Charac == ';') {
				String newName = name.substring(0, i);
				return newName;
			}
		}
		return null;
    }

    public String userPassword(String name) {
		for (int i = 0; i < name.length(); i++) {
			char Charac = name.charAt(i);
			if (Charac == ';') {
				if (Charac == name.charAt(name.length() - 1)) {
					nameLst.remove(nameLst.size() - 1);
					break;
				} else {
					String price = name.substring(i + 1, name.length());
					return price;
				}
			}
		}
		return null;
    }

    public void addNameAndPass(String line) {
		String name = line.trim();
		String newName = userName(name);
		if (newName != null) {
			this.nameLst.add(newName);
			String password = userPassword(name);
			if (password != null) {
				this.passLst.add(password);
			}
		}
    }

    public void loadFile(String filename) {
	InputStream in = loader.getResourceAsStream(filename);

	if (in == null) {
		System.out.println("No such file " + filename);
		return;
	}
        Scanner scan = new Scanner(in);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.startsWith("//")) {
		continue;
            } else {
		addNameAndPass(line);
            }
	}
	scan.close();
    }
}
