package org.csanchez.jenkins.plugins.kubernetes.pipeline

podTemplate(label: '$NAME', idleMinutes: 0, containers: [
        containerTemplate(name: 'busybox', image: 'busybox', ttyEnabled: true, command: '/bin/cat'),
]) {

    node ('$NAME') {
        stage('Run') {
            container('busybox') {
                    sh 'for i in `seq 1 10`; do echo $i; sleep 5; done'
                    sh 'ps'
            }
            container('busybox') {
                sh 'ps'
            }
            echo 'finished the test!'
        }

    }
}
