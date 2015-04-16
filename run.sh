#This shell scripts will unpack the distribution tar, and run the container
cd lesie-distribution/target
tar -zxvf *.tar.gz
cd /home/karabom/projects/lesieS/lesie-distribution/target/lesie-distribution-0.1-SNAPSHOT/bin
./karaf
