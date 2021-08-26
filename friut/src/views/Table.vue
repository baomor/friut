<template>
  <el-table
      :data="tableData"
      border
      style="width: 100%">
    <el-table-column
        fixed
        prop="id"
        label="水果Id"
        width="160">
    </el-table-column>
    <el-table-column
        prop="name"
        label="水果名称"
        width="160">
    </el-table-column>
    <el-table-column
        prop="sale"
        label="水果销量"
        width="160">
    </el-table-column>
    <el-table-column
        prop="icon"
        label="图片"
        width="160">
      <template slot-scope="scope">
        <img :src="scope.row.icon" style="height: 70px">
      </template>
    </el-table-column>
    <el-table-column
        fixed="right"
        label="操作"
        width="160">
      <template slot-scope="scope">
        <el-button @click="fruitDelete(scope.row)" type="text" size="small">删除</el-button>
        <el-button @click="findFruit(scope.row)" type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "Table",
  methods: {
    findFruit(row){
      this.$router.push({
            path:'/edit',
            query:{
              id:row.id
            }
      })
    },
    fruitDelete(row) {
      let _this=this
      this.$confirm('是否确定删除'+row.name+'?', '删除数据', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete("http://localhost:8181/fruit/delete/"+row.id).then(function (resp) {
          if (resp.data){
            _this.$alert(row.name+'删除成功','删除数据',{
              confirmButtonText: '确定',
              callback: action => {
                location.reload()
              }
            })
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });


    }
  },
  created() {
    let _this=this
    axios.get("http://localhost:8181/fruit/list").then(function (resp){
      console.log(resp)
      _this.tableData=resp.data
    })
  },
  data() {
    return {
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1518 弄',
        zip: 200333
      }, {
        date: '2016-05-04',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1517 弄',
        zip: 200333
      }, {
        date: '2016-05-01',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1519 弄',
        zip: 200333
      }, {
        date: '2016-05-03',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1516 弄',
        zip: 200333
      }]
    }
  }
}
</script>