package myimplements;

import java.util.Scanner;

public class SegmentTreeLR {
    static class node{
        int l,r;
        long sum,add = 0;
        public node(int l, int r, long sum, long add) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.add = add;
        }
        public node() {
        }
    }

    static node node[];
    static int a[];
    static int p;
    static int n,m;

    static void build(int k,int l,int r){
        node[k].l = l;
        node[k].r = r;
        if(l==r){
            node[k].sum = a[l];
            return;
        }
        int mid = (l+r)/2;
        build(k*2,l,mid);
        build(k*2+1,mid+1,r);
        node[k].sum = node[k*2].sum + node[k*2+1].sum;
    }

    static void push(int k){
        if(node[k].add != 0){
            node[k*2].sum += node[k].add * (node[k*2].r - node[k*2].l + 1);
            node[k*2+1].sum += node[k].add * (node[k*2+1].r - node[k*2+1].l + 1);
            //System.out.println(node[k*2].l+" "+node[k*2].r+" "+node[k*2].sum);
            node[k*2].add += node[k].add;
            node[k*2+1].add += node[k].add;
            node[k].add = 0;
        }
    }

    static void change(int k,int l,int r,int d){
        if(l <= node[k].l && r >= node[k].r){
            node[k].sum += (long)d * (node[k].r - node[k].l + 1);
            node[k].add += d;
            //System.out.println(node[k].l+" "+node[k].r+" "+node[k].sum);
            return ;
        }
        push(k);
        int mid = (node[k].r + node[k].l)/2;
        if(l <= mid) change(k*2,l,r,d);
        if(r > mid) change(k*2+1,l,r,d);
        node[k].sum = node[k*2].sum + node[k*2+1].sum;
    }

    static void changeX(int k,int l,int r,int d){
        if(l <= node[k].l && r >= node[k].r){
            node[k].sum += (long)d * (node[k].r - node[k].l + 1) % p;
            node[k].add = (d * node[k].add) % p;
            a[k] = a[k] * d % p;
            //System.out.println(node[k].l+" "+node[k].r+" "+node[k].sum);
            return ;
        }
        push(k);
        int mid = (node[k].r + node[k].l)/2;
        if(l <= mid) changeX(k*2,l,r,d);
        if(r > mid) changeX(k*2+1,l,r,d);
        node[k].sum = node[k*2].sum + node[k*2+1].sum;
    }

    static long ask(int k,int l,int r){
        if(l <= node[k].l && r >= node[k].r){
            //System.out.println(node[k].l+" "+node[k].r+" "+node[k].sum);
            return node[k].sum;
        }
        push(k);
        int mid = (node[k].r + node[k].l)/2;
        long val = 0;
        if(l <= mid) val += ask(k*2,l,r);
        if(r > mid) val += ask(k*2+1,l,r);
        return val;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        p = input.nextInt();
        node = new node[4*n+1];
        for(int i=0;i<4*n+1;i++){
            node[i] = new node();
        }
        a = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = input.nextInt();
        }
        build(1,1,n);
        m = input.nextInt();
        while (m-- > 0) {
            int op = input.nextInt();
            if (op == 2) {
                int l = input.nextInt();
                int r = input.nextInt();
                int c = input.nextInt();
                change(1, l, r, c);
            } else if (op == 3) {
                int l = input.nextInt();
                int r = input.nextInt();
                System.out.println(ask(1, l, r));
            } else {
                int l = input.nextInt();
                int r = input.nextInt();
                int c = input.nextInt();
                changeX(1, l, r, c);
            }

        }

    }

}
