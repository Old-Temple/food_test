<template>

    <v-data-table
        :headers="headers"
        :items="deliveryHis"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DeliveryHisView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "menuId", value: "menuId" },
                { text: "shopId", value: "shopId" },
                { text: "customerId", value: "customerId" },
                { text: "price", value: "price" },
                { text: "customerAddress", value: "customerAddress" },
                { text: "shopAddress", value: "shopAddress" },
            ],
            deliveryHis : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/deliveryHis'))

            temp.data._embedded.deliveryHis.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.deliveryHis = temp.data._embedded.deliveryHis;
        },
        methods: {
        }
    }
</script>

