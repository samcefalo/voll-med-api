alter table medicos add enable BIT not null;
update medicos set enable = 1;