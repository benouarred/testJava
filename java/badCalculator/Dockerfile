FROM frolvlad/alpine-oraclejdk8:slim
VOLUME add /app
ADD target/badcalculator-1.0.jar badcalculator.jar
RUN sh -c 'touch /badcalculator.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-classpath","/badcalculator.jar","com.sfeir.badcalculator.CalculatorMain"]