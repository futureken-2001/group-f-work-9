
pipeline{

    agent {
        label 'docker-agent'
    }
     tools{
        maven "myMaven"
    }


     stages{

      stage('Start PostgreSQL') {
           steps {
             // Start PostgreSQL defined in docker-compose.yml and referenced .env for sensitive variables.
             bat 'docker-compose up -d'


           }
         }


         stage("Build"){

                 steps{
                     echo"Building the application"
                     bat "mvn clean install"
                 }
          }

         stage("Run and Test"){

               steps{
                 echo "Executing code and running necessary tests"
                  bat "mvn clean verify"
               }

         }

          stage("Issue surefire report"){

                             steps{
                               echo "Generating report..."
                            bat "mvn surefire-report:report"
                             }

          }

          stage('SonarQube Analysis') {

           steps {
               withSonarQubeEnv("mySonar") {
                  bat "mvn clean verify sonar:sonar -Dsonar.projectKey=group5Proj -Dsonar.projectName='group5Proj'"
                                }
                      }
              post {
                    success {
                        emailext(
                            subject: "Jenkins Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                            body: """
                            Build Successful!
                            - Job: ${env.JOB_NAME}
                            - Build Number: ${env.BUILD_NUMBER}
                            - Build URL: ${env.BUILD_URL}
                            """,
                        to: 'andrewssuubi@gmail.com , aitaryanodrua@gmail.com , alexandermwase13@gmail.com'
                        )
                    }


                    failure {
                        emailext(
                            subject: "Jenkins Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                            body: """
                            Build Failed!
                            - Job: ${env.JOB_NAME}
                            - Build Number: ${env.BUILD_NUMBER}
                            - Build URL: ${env.BUILD_URL}

                            Please check the logs for more details.
                            """,
                            to: 'aitaryanodrua@gmail.com , andrewssuubi@gmail.com , kyacamear@gmail.com '
                        )
                    }
                }

          }

          stage("Deploy"){

                     steps{

                      echo "Deploying Application..."
                    }

              }

         }

    }




