package com.github.soulcrystal.mightandmagic.object.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Homm_Ore_Pile_Block extends Block
{

	public static final DirectionProperty FACING= HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(5, 0, 8, 7, 2, 10),
			Block.makeCuboidShape(12, 0, 7, 13, 1, 8),
			Block.makeCuboidShape(4, 0, 6, 5, 1, 7),
			Block.makeCuboidShape(8, 0, 6, 9, 1, 7),
			Block.makeCuboidShape(10, 2, 8, 11, 3, 9),
			Block.makeCuboidShape(7, 2, 9, 8, 3, 10),
			Block.makeCuboidShape(6, 0, 12, 7, 1, 13),
			Block.makeCuboidShape(4, 0, 10, 5, 1, 11),
			Block.makeCuboidShape(13, 0, 12, 14, 1, 13),
			Block.makeCuboidShape(12, 0, 13, 13, 1, 14),
			Block.makeCuboidShape(12, 0, 9, 13, 1, 10),
			Block.makeCuboidShape(6, 0, 13, 8, 2, 15),
			Block.makeCuboidShape(9, 0, 7, 11, 2, 9),
			Block.makeCuboidShape(7, 0, 9, 9, 2, 11),
			Block.makeCuboidShape(9, 2, 10, 11, 4, 12),
			Block.makeCuboidShape(10, 0, 9, 12, 2, 11),
			Block.makeCuboidShape(8, 0, 11, 10, 2, 13),
			Block.makeCuboidShape(10, 0, 11, 12, 2, 13)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(9, 0, 6, 11, 2, 8),
			Block.makeCuboidShape(3, 0, 8, 4, 1, 9),
			Block.makeCuboidShape(11, 0, 9, 12, 1, 10),
			Block.makeCuboidShape(7, 0, 9, 8, 1, 10),
			Block.makeCuboidShape(5, 2, 7, 6, 3, 8),
			Block.makeCuboidShape(8, 2, 6, 9, 3, 7),
			Block.makeCuboidShape(9, 0, 3, 10, 1, 4),
			Block.makeCuboidShape(11, 0, 5, 12, 1, 6),
			Block.makeCuboidShape(2, 0, 3, 3, 1, 4),
			Block.makeCuboidShape(3, 0, 2, 4, 1, 3),
			Block.makeCuboidShape(3, 0, 6, 4, 1, 7),
			Block.makeCuboidShape(8, 0, 1, 10, 2, 3),
			Block.makeCuboidShape(5, 0, 7, 7, 2, 9),
			Block.makeCuboidShape(7, 0, 5, 9, 2, 7),
			Block.makeCuboidShape(5, 2, 4, 7, 4, 6),
			Block.makeCuboidShape(4, 0, 5, 6, 2, 7),
			Block.makeCuboidShape(6, 0, 3, 8, 2, 5),
			Block.makeCuboidShape(4, 0, 3, 6, 2, 5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(8, 0, 9, 10, 2, 11),
			Block.makeCuboidShape(7, 0, 3, 8, 1, 4),
			Block.makeCuboidShape(6, 0, 11, 7, 1, 12),
			Block.makeCuboidShape(6, 0, 7, 7, 1, 8),
			Block.makeCuboidShape(8, 2, 5, 9, 3, 6),
			Block.makeCuboidShape(9, 2, 8, 10, 3, 9),
			Block.makeCuboidShape(12, 0, 9, 13, 1, 10),
			Block.makeCuboidShape(10, 0, 11, 11, 1, 12),
			Block.makeCuboidShape(12, 0, 2, 13, 1, 3),
			Block.makeCuboidShape(13, 0, 3, 14, 1, 4),
			Block.makeCuboidShape(9, 0, 3, 10, 1, 4),
			Block.makeCuboidShape(13, 0, 8, 15, 2, 10),
			Block.makeCuboidShape(7, 0, 5, 9, 2, 7),
			Block.makeCuboidShape(9, 0, 7, 11, 2, 9),
			Block.makeCuboidShape(10, 2, 5, 12, 4, 7),
			Block.makeCuboidShape(9, 0, 4, 11, 2, 6),
			Block.makeCuboidShape(11, 0, 6, 13, 2, 8),
			Block.makeCuboidShape(11, 0, 4, 13, 2, 6)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(6, 0, 5, 8, 2, 7),
			Block.makeCuboidShape(8, 0, 12, 9, 1, 13),
			Block.makeCuboidShape(9, 0, 4, 10, 1, 5),
			Block.makeCuboidShape(9, 0, 8, 10, 1, 9),
			Block.makeCuboidShape(7, 2, 10, 8, 3, 11),
			Block.makeCuboidShape(6, 2, 7, 7, 3, 8),
			Block.makeCuboidShape(3, 0, 6, 4, 1, 7),
			Block.makeCuboidShape(5, 0, 4, 6, 1, 5),
			Block.makeCuboidShape(3, 0, 13, 4, 1, 14),
			Block.makeCuboidShape(2, 0, 12, 3, 1, 13),
			Block.makeCuboidShape(6, 0, 12, 7, 1, 13),
			Block.makeCuboidShape(1, 0, 6, 3, 2, 8),
			Block.makeCuboidShape(7, 0, 9, 9, 2, 11),
			Block.makeCuboidShape(5, 0, 7, 7, 2, 9),
			Block.makeCuboidShape(4, 2, 9, 6, 4, 11),
			Block.makeCuboidShape(5, 0, 10, 7, 2, 12),
			Block.makeCuboidShape(3, 0, 8, 5, 2, 10),
			Block.makeCuboidShape(3, 0, 10, 5, 2, 12)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public Homm_Ore_Pile_Block(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		switch(state.get(FACING))
		{
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}
	
	public BlockState getStateForPlaement(BlockItemUseContext context)
	{
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	/**
	 * Returnsthe blockstate with the given rotation from the passed blockstate.
	 * If inapplicable, returns the passed blockstate.
	 * 
	 * @deprecated call via {@link IBlockSate#withRotation(Rotation)} whenever possible
	 * implementing/overriding is fine.
	 */
	@Override
	public BlockState rotate(BlockState state, Rotation rot)
	{
		return state.with(FACING,  rot.rotate(state.get(FACING)));
	}
	
	/**
	 * Returnsthe blockstate with the given mirror from the passed blockstate.
	 * If inapplicable, returns the passed blockstate.
	 * 
	 * @deprecated call via {@link IBlockSate#withRotation(Rotation)} whenever possible
	 * implementing/overriding is fine.
	 */
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn)
	{
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder)
	{
		builder.add(FACING);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) 
	{
		if(!worldIn.isRemote())
		{
			ServerWorld serverWorld = (ServerWorld)worldIn;
			LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
			serverWorld.addLightningBolt(entity);;
		}
	return ActionResultType.SUCCESS;
		}
}
