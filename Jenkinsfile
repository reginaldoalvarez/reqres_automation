podTemplate(containers: [
    containerTemplate(name: 'jnlp', image: 'tevolvers/jnlp-docker:1.1', args: '${computer.jnlpmac} ${computer.name}')
]) {
    node(POD_LABEL) {
        container('jnlp') {
            stage('checkout') {
                git ([
                    url: 'git@github.com:boya678/reqres_automation.git',
                    credentialsId: 'github-ssh-jenkins',
                    branch: 'master'
                ])
            }
            stage('Run integration tests') {
                sh 'docker build -t reqres:1.0 .'
                sh 'docker run --name reqresrun$BUILD_NUMBER reqres:1.0'
                sh 'docker cp reqresrun$BUILD_NUMBER:/usr/src/automation/target .'
                sh 'docker cp reqresrun$BUILD_NUMBER:/usr/src/automation/build .'
                junit '**/TEST-*.xml'
                archiveArtifacts 'target/site/serenity/**'
            }
            stage('Publish report'){
                publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site/serenity',
                reportFiles: 'index.html',
                reportName: 'Serenity Report'
        ])
            }
        }
    }
}
