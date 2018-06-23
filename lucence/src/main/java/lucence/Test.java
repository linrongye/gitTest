package lucence;

import domain.Item;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import util.DbUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            Connection connection=DbUtil.gerConnection();
            String sql="select * from item";

             PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Item> list=getList(rs);


            Directory d=FSDirectory.open(new File("D:\\lucene"));
            IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_4_10_3,new StandardAnalyzer());
            IndexWriter writer=new IndexWriter(d,config);
            Document document=null;
            List<Document> doList=new ArrayList();
            for (Item item : list) {
                document=new Document();
                document.add(new LongField("id",item.getId(), org.apache.lucene.document.Field.Store.YES));
                document.add(new TextField("name",item.getName(), org.apache.lucene.document.Field.Store.YES));
                document.add(new LongField("price", (long) item.getPrice(), org.apache.lucene.document.Field.Store.YES));
                document.add(new TextField("detail",item.getDetail(), org.apache.lucene.document.Field.Store.YES));
                writer.addDocument(document);
            }

            writer.close();
            /*Directory fsDirectory = FSDirectory.open(new File(""));
            IndexReader indexReader=DirectoryReader.open(fsDirectory);
            IndexSearcher indexSearcher=new IndexSearcher(indexReader);*/
          //  Query query=
            //indexSearcher.search();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void delete(){
        try {
            Directory d=FSDirectory.open(new File("D:\\lucene"));
            IndexWriterConfig indexWriterConfig=new IndexWriterConfig(Version.LUCENE_4_10_3,new StandardAnalyzer());
            IndexWriter indexWriter=new IndexWriter(d,indexWriterConfig);

            Term t=new Term("id","1");
            indexWriter.deleteDocuments(t);
            //indexWriter.deleteAll();
            indexWriter.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void update(){

        try {
            Directory d=FSDirectory.open(new File("D:\\lucene"));
            IndexWriterConfig indexWriterConfig=new IndexWriterConfig(Version.LUCENE_4_10_3,new StandardAnalyzer());
            IndexWriter indexWriter=new IndexWriter(d,indexWriterConfig);
            Term t=new Term("id","7");
            TermQuery tem=new TermQuery(new Term(""));//用于精确查找
            NumericRangeQuery na=NumericRangeQuery.newLongRange("price",70L,1000L,false,false);
            BooleanQuery booleanClauses=new BooleanQuery();
            booleanClauses.add(tem,BooleanClause.Occur.MUST);
            booleanClauses.add(na,BooleanClause.Occur.MUST);
            Document document=new Document();
            document.add(new LongField("id",7, org.apache.lucene.document.Field.Store.YES));
            document.add(new TextField("name","linry", org.apache.lucene.document.Field.Store.YES));
            document.add(new LongField("price", 3333, org.apache.lucene.document.Field.Store.YES));
            document.add(new TextField("detail","sadaksdjlasdjlsakdj", org.apache.lucene.document.Field.Store.YES));
            indexWriter.updateDocument(t,document);
            indexWriter.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Item> getList( ResultSet rs){
        List<Item> list=null;
        try {
            Item item=null;
            list=new ArrayList <Item>();
            while (rs.next()){
                item=new Item();
                item.setId(rs.getInt("id"));
                item.setName( rs.getString("name"));
                item.setPrice(rs.getFloat("price"));
                item.setPic( rs.getString("pic"));
                item.setDetail( rs.getString("detail"));
                item.setCreatetime(rs.getDate("createtime"));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @org.junit.Test
    public void search(){

        try {
            Directory directory=FSDirectory.open(new File("D:\\lucene"));
            IndexReader indexReader=DirectoryReader.open(directory);
            IndexSearcher indexSearcher=new IndexSearcher(indexReader);
            TermQuery tem=new TermQuery(new Term("detail","质"));
          //  tem.setBoost(1000f);
            TopDocs search = indexSearcher.search(tem, 10);
            Analyzer analyzer=new StandardAnalyzer();
            QueryScorer scorer = new QueryScorer(tem);
            Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
            SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter("<font color='red'>","</font>");
            Highlighter highlighter=new Highlighter(simpleHTMLFormatter,scorer);
            highlighter.setTextFragmenter(fragmenter);
             ScoreDoc[] docs = search.scoreDocs;
            for (ScoreDoc doc : docs) {
                Document document = indexSearcher.doc(doc.doc);
                String name=document.get("detail");
                if(document.get("detail")!=null){
                    TokenStream tokenStream = TokenSources
                            .getTokenStream(document, "detail", analyzer);
                    name = highlighter.getBestFragment(tokenStream, name);   }
                System.out.println(document.get("id")+"  "+name);
            }
        } catch (Exception   e) {
            e.printStackTrace();
        }
    }
   /* public static void setBean(ResultSet rs,Class c){
        try {
            //Object instance = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                String name=field.getName();
                char c1=Character.toUpperCase(name.charAt(0));
                name= "set"+c1+name.substring(1);
                Method method = c.getDeclaredMethod(name,field.getType().getClass());
                method.invoke(rs.get)
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }*/
}
