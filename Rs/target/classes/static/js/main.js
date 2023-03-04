const app = new Vue({
	el: '#app',
	data: {
		products: [
			{
				id: 1,
				name: 'Product 1',
				image: 'path/to/product1.jpg',
				description: 'This is the first product',
				reviews: [
					{
						id: 1,
						title: 'Great product!',
						text: 'I really enjoyed using this product',
						rating: 5
					},
					{
						id: 2,
						title: 'Not bad',
						text: 'It was okay, nothing special',
						rating: 3
					}
				]
			},
			{
				id: 2,
				name: 'Product 2',
				image: 'path/to/product2.jpg',
				description: 'This is the second product',
				reviews: [
					{
						id: 3,
						title: 'Amazing!',
						text: 'I loved using this product',
						rating: 5
					},
					{
						id: 4,
						title: 'Not for me',
						text: 'I did not like this product',
						rating: 1
					}
				]
			}
		],
		newReview: {
			title: '',
			text: '',
			rating: 0
		}
	},
	methods: {
		addReview(product) {
			product.reviews.push(this.newReview);
			this.newReview = {
				title: '',
				text: '',
				rating: 0
			};
		}
	}
});
