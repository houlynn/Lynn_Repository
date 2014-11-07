using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Data.SqlClient;

namespace DataHleper
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            SqlConnection sqlConn = this.geetSqlConnet();
            this.DataContext = this.getFine(sqlConn);
           
   
        }


        private SqlConnection geetSqlConnet() {
            String strcont = "server=.;database=SalesManagement;uid=sa;pwd=00000;";
            SqlConnection sqlConn = new SqlConnection(strcont);
            sqlConn.Open();
             return sqlConn;
        
        }


        private IList<FileInf> getFine(SqlConnection conn)
        {
            string query = "select * from  _ModuleField";
            SqlCommand cmmd = new SqlCommand(query, conn);
            SqlDataReader read= cmmd.ExecuteReader();
            IList<FileInf> list = new List<FileInf>();
          
            while (read.Read()) {
                string name = read["tf_fieldOrder"].ToString();
                FileInf f = new FileInf() { Name = name };
                list.Add(f);
            
            
            }
            read.Close();
            conn.Close();
            return list;
        
        
        }

        class FileInf {

            public string Name { get; set; }
            public string Type { get; set; }

            public int lenght { get; set; }

        }


    }
}
