env=$1

cp inventory_file ./files/environment/$env/
cp param.yml ./files/environment/$env/group_vars/all/

ansible-playbook -i files/environment/$env/inventory_file files/install.yml

