package com.akshay.hackerrank.functionalProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.akshay.hackerrank.algorithms.TwoArrayProblem;
//zgrep "Parameters: {\"location_update" production.log* | cut -f1,4 -d"{" | grep -v "{}}" > /tmp/akshay2.txt
public class NetworkTypeToDeviceMapping {

	public static class Operator{
		private String network_operator;
		private String deviceId;

		public String getNetwork_operator() {
			return network_operator;
		}

		public void setNetwork_operator(String network_operator) {
			this.network_operator = network_operator;
		}

		public Operator(String network, String id) {
			this.network_operator = network;
			this.setDeviceId(id);
		}

		public String getDeviceId() {
			return deviceId;
		}

		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

	}

	public static void main(String[] args) {

		BufferedReader br = null;
		BufferedReader br2 = null;
		// Key is Network Type
		HashSet<String> deviceIDs = new HashSet<String>();
		HashMap<String,ArrayList<Operator>> listOfDevices = new HashMap<String,ArrayList<Operator>>();
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("/Users/akshay/Desktop/rubyWorkspace/akshay.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] val = sCurrentLine.split(",");
				String network = val[2].split("=>")[1].toString();
				String deviceVal = val[4].split("=>")[1].toString();
				deviceIDs.add(deviceVal);
				Operator temp = new Operator(network, deviceVal);
				String key = val[3].split("}")[0].split("=>")[1].toString(); // network type
				//System.out.println(key + " " + temp.getDeviceId() + " " + temp.getNetwork_operator());
				ArrayList<Operator> tOperator = listOfDevices.get(key);
				if(tOperator == null) tOperator = new ArrayList<Operator>();
				tOperator.add(temp);
				listOfDevices.put(key, tOperator);
			}

			br2 = new BufferedReader(new FileReader("/Users/akshay/Desktop/rubyWorkspace/akshay2.txt"));
			while ((sCurrentLine = br2.readLine()) != null) {
				String[] val = sCurrentLine.split(",");
				String network = val[2].split("=>")[1].toString();
				String deviceVal = val[4].split("=>")[1].toString();
				deviceIDs.add(deviceVal);
				Operator temp = new Operator(network, deviceVal);
				String key = val[3].split("}")[0].split("=>")[1].toString(); // network type
				//System.out.println(key + " " + temp.getDeviceId() + " " + temp.getNetwork_operator());
				ArrayList<Operator> tOperator = listOfDevices.get(key);
				if(tOperator == null) tOperator = new ArrayList<Operator>();
				tOperator.add(temp);
				listOfDevices.put(key, tOperator);
			}

			System.out.println("---------------------------------------------------");
			HashSet<String> twoGDeviceList = new HashSet<String>();
			Set<String> keys = listOfDevices.keySet();
			for (String key : keys) {
				System.out.println("Key: " + key);
				if (key.equals("1") || key.equals("2") || key.equals("4") || key.equals("7")) {
					ArrayList<Operator> list = listOfDevices.get(key);
					for (int i = 0; list != null && i < list.size(); i++) { 
						String deviceId = list.get(i).getDeviceId();
						twoGDeviceList.add(deviceId);
					}
				}
				System.out.println("---------------------------------------------------");
			}
			List<String> listFull = new ArrayList<String>(deviceIDs);
			Collections.sort(listFull);
			
			for (int i = 0; i < listFull.size(); i++) {
				if (!twoGDeviceList.contains(listFull.get(i))) {
					System.out.println(listFull.get(i));
				}
			}
			
			System.out.println("---------------------------------------------------");
			


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
