package com.myorg;

import software.amazon.awscdk.App;

public class AmazonApp {
	public static void main(final String[] args) {
		App app = new App();
		VpcStack vpcTStack = new VpcStack(app, "Vpc");
		ClusterStack clusterStack = new ClusterStack(app, "Cluster", vpcTStack.getVpc());
		clusterStack.addDependency(vpcTStack);
		
		Service01Stack service01Stack = new Service01Stack(app, "Service01", clusterStack.getCluster());
		service01Stack.addDependency(clusterStack);
		app.synth();
	}
}
