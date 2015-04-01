After running the tests with mvn clean install you will see in the schema.sql the generated foreign key constraints:


    alter table entity_filters 
        add constraint FKra38l70n01disvkge7i9ff5ym 
        foreign key (filter_pk) 
        references abstract_filter;

    alter table entity_filters 
        add constraint FKmx2xw6tik0j07a9mc1ia18xpv 
        foreign key (entity_pk) 
        references ProductModel;

    alter table entity_filters 
        add constraint FKi1na4cq6d8k1e3nyv1x5n7c84 
        foreign key (entity_pk) 
        references CategoryModel;
