env=$1

cp inventory_file ${pwd}/files/environment/$env/
cp param.yml {$pwd}/files/environment/$env/group_vars/all/

ansible-playbook -i files/environment/$env/inventory_file files/install.yml

