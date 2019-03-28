FROM payara/micro

COPY target/SessionBeans.war ${DEPLOY_DIR}
