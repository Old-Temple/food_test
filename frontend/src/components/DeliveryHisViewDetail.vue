<template>

    <v-card outlined>
        <v-card-title>
            DeliveryHis # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="MenuId" v-model="item.menuId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ShopId" v-model="item.shopId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Price" v-model="item.price" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerAddress" v-model="item.customerAddress" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ShopAddress" v-model="item.shopAddress" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DeliveryHisViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/deliveryHis/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

