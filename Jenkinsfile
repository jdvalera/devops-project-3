  
pipeline {
	agent any
	tools {
    	maven 'local-mvn'
	}
	stages {
    	stage("Checkout") {   
        	steps {               	 
            	git branch: 'main',  url: 'https://github.com/jdvalera/devops-project-3'          	 
        	}    
    	}
    	stage('Build') {
        	steps {
        	sh "mvn compile"  	 
        	}
    	}
    	stage("Unit test") {          	 
        	steps {  	 
            	sh "mvn test"          	 
       	    }
        }
    	stage("Package") {          	 
        	steps {  	 
            	sh "mvn package"  	 
       	    }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/*.war*', onlyIfSuccessful: true
        }
        success {
            deploy adapters: [tomcat9(url: 'http://35.236.48.65:8080/', 
                                credentialsId: 'tomcat')], 
                            war: 'target/*.war',
                            contextPath: 'app'
        }
        failure {
            mail to: 'devops.valera@gmail.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}