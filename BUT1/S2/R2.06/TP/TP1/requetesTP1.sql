set schema 'tp1';

select nome from emp inner join dept on emp.nodept=dept.nodept where nomdept='VENTES';
select nome from emp inner join dept on emp.nodept=dept.nodept where nomdept='VENTES' and poste='DIRECTEUR';
select * from dept where nodept not in (select distinct nodept from emp);
select nodept, count(*) from emp group by (nodept);
select nomdept, count(matr) from emp e right join dept d on e.nodept=d.nodept group by e.nodept,nomdept;
select sum(sal + comm) from emp;
select nodept, sum(sal) from emp group by (nodept);
select nodept, sum(sal+comm) from emp group by (nodept);
select matr, nome from emp where matr in (select sub from dirige inner join emp on sup=matr where poste='DIRECTEUR');
select matr, nome from emp where poste='INGENIEUR' and matr in (select sub from dirige inner join emp on sup=matr where poste='DIRECTEUR');
select * from emp where dateemb in (select min(dateemb) from emp inner join dept on emp.nodept=dept.nodept where poste='INGENIEUR' and nomdept='RECHERCHES');